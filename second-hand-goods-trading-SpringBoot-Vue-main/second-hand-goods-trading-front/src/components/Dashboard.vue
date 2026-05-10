<template>
  <div class="dashboard-container">
    <!-- 顶部数据指标卡片 -->
    <el-row :gutter="20" class="top-cards">
      <el-col :span="6">
        <el-card class="box-card metric-card users-card" shadow="hover">
          <div class="card-content">
            <div class="card-icon">
              <i class="el-icon-user"></i>
            </div>
            <div class="card-info">
              <div class="card-title">总用户数</div>
              <div class="card-value">{{ totalUsers | formatNumber }}</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="box-card metric-card products-card" shadow="hover">
          <div class="card-content">
            <div class="card-icon">
              <i class="el-icon-goods"></i>
            </div>
            <div class="card-info">
              <div class="card-title">总商品数</div>
              <div class="card-value">{{ totalProducts | formatNumber }}</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="box-card metric-card orders-card" shadow="hover">
          <div class="card-content">
            <div class="card-icon">
              <i class="el-icon-document"></i>
            </div>
            <div class="card-info">
              <div class="card-title">总订单数</div>
              <div class="card-value">{{ totalOrders | formatNumber }}</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="box-card metric-card transaction-card" shadow="hover">
          <div class="card-content">
            <div class="card-icon">
              <i class="el-icon-s-marketing"></i>
            </div>
            <div class="card-info">
              <div class="card-title">总交易额</div>
              <div class="card-value">¥{{ totalTransactionAmount | formatNumber }}</div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 中间图表区域 -->
    <el-row :gutter="20" class="middle-charts">
      <el-col :span="16">
        <el-card class="box-card chart-card" shadow="hover">
          <div slot="header" class="clearfix">
            <span><i class="el-icon-data-line"></i> 最近7天订单量趋势</span>
          </div>
          <div id="lineChart" style="width: 100%; height: 350px;"></div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card class="box-card chart-card" shadow="hover">
          <div slot="header" class="clearfix">
            <span><i class="el-icon-pie-chart"></i> 商品分类占比</span>
          </div>
          <div id="pieChart" style="width: 100%; height: 350px;"></div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from 'echarts';

const CATEGORY_NAMES = {
  1: '电子产品',
  2: '家用电器',
  3: '服装鞋帽',
  4: '图书影音',
  5: '其他'
};

export default {
  name: 'Dashboard',
  filters: {
    formatNumber(value) {
      if (typeof value !== 'number') return value;
      return value.toLocaleString();
    }
  },
  data() {
    return {
      totalUsers: 0,
      totalProducts: 0,
      totalOrders: 0,
      totalTransactionAmount: 0,

      lineChartData: {
        dates: [],
        orders: []
      },

      pieChartData: [],

      lineChartInstance: null,
      pieChartInstance: null
    };
  },
  mounted() {
    this.fetchAllData();
  },
  methods: {
    fetchAllData() {
      Promise.all([
        this.fetchStatisticsOverview(),
        this.fetchOrdersLast7Days(),
        this.fetchCategoryStatistics()
      ]).then(() => {
        this.$nextTick(() => {
          this.initLineChart();
          this.initPieChart();
        });
      });
    },
    fetchStatisticsOverview() {
      return this.$api.getStatisticsOverview().then(res => {
        if (res.status_code === 1 && res.data) {
          this.totalUsers = res.data.totalUsers || 0;
          this.totalProducts = res.data.totalProducts || 0;
          this.totalOrders = res.data.totalOrders || 0;
          this.totalTransactionAmount = res.data.totalTransactionAmount || 0;
        }
      }).catch(e => {
        console.log(e);
      });
    },
    fetchOrdersLast7Days() {
      return this.$api.getOrdersLast7Days().then(res => {
        if (res.status_code === 1 && res.data) {
          const last7Days = this.getLast7Days();
          const orderMap = {};
          (res.data || []).forEach(item => {
            const dateStr = this.formatDate(new Date(item.date));
            orderMap[dateStr] = item.count;
          });
          const dates = [];
          const orders = [];
          last7Days.forEach(date => {
            dates.push(this.formatDateShort(date));
            orders.push(orderMap[date] || 0);
          });
          this.lineChartData.dates = dates;
          this.lineChartData.orders = orders;
        }
      }).catch(e => {
        console.log(e);
      });
    },
    fetchCategoryStatistics() {
      return this.$api.getCategoryStatistics().then(res => {
        if (res.status_code === 1 && res.data) {
          this.pieChartData = (res.data || []).map(item => ({
            value: item.value,
            name: CATEGORY_NAMES[item.label] || `分类${item.label}`
          }));
        }
      }).catch(e => {
        console.log(e);
      });
    },
    getLast7Days() {
      const days = [];
      for (let i = 6; i >= 0; i--) {
        const d = new Date();
        d.setDate(d.getDate() - i);
        days.push(this.formatDate(d));
      }
      return days;
    },
    formatDate(date) {
      const y = date.getFullYear();
      const m = String(date.getMonth() + 1).padStart(2, '0');
      const d = String(date.getDate()).padStart(2, '0');
      return `${y}-${m}-${d}`;
    },
    formatDateShort(date) {
      const m = String(date.getMonth() + 1).padStart(2, '0');
      const d = String(date.getDate()).padStart(2, '0');
      return `${m}-${d}`;
    },
    initLineChart() {
      const chartDom = document.getElementById('lineChart');
      if (!chartDom) return;

      if (this.lineChartInstance) {
        this.lineChartInstance.dispose();
      }
      this.lineChartInstance = echarts.init(chartDom);

      const option = {
        tooltip: {
          trigger: 'axis',
          backgroundColor: 'rgba(50, 50, 50, 0.9)',
          borderColor: '#333',
          textStyle: { color: '#fff' },
          axisPointer: { type: 'cross' }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: this.lineChartData.dates,
          axisLine: { lineStyle: { color: '#d9d9d9' } },
          axisLabel: { color: '#666', fontSize: 12 }
        },
        yAxis: {
          type: 'value',
          min: 0,
          axisLine: { show: false },
          splitLine: { lineStyle: { color: '#f5f5f5' } },
          axisLabel: { color: '#666' }
        },
        series: [
          {
            name: '订单量',
            type: 'line',
            data: this.lineChartData.orders,
            smooth: true,
            areaStyle: {
              color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                { offset: 0, color: 'rgba(64, 158, 255, 0.6)' },
                { offset: 1, color: 'rgba(64, 158, 255, 0.1)' }
              ])
            },
            lineStyle: { color: '#409EFF', width: 3 },
            itemStyle: { color: '#409EFF' },
            symbol: 'circle',
            symbolSize: 8,
            emphasis: {
              itemStyle: {
                borderColor: '#fff',
                borderWidth: 2,
                shadowBlur: 10,
                shadowColor: 'rgba(0, 0, 0, 0.3)'
              }
            }
          }
        ]
      };
      this.lineChartInstance.setOption(option);
      window.addEventListener('resize', this.handleResize);
    },
    initPieChart() {
      const chartDom = document.getElementById('pieChart');
      if (!chartDom) return;

      if (this.pieChartInstance) {
        this.pieChartInstance.dispose();
      }
      this.pieChartInstance = echarts.init(chartDom);

      const option = {
        tooltip: {
          trigger: 'item',
          formatter: '{b}: {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          left: '5%',
          top: 'middle',
          textStyle: { color: '#666' }
        },
        series: [
          {
            name: '商品分类',
            type: 'pie',
            radius: ['45%', '70%'],
            center: ['60%', '50%'],
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 18,
                fontWeight: 'bold'
              }
            },
            labelLine: { show: false },
            data: this.pieChartData.length > 0 ? this.pieChartData : [
              { value: 0, name: '暂无数据' }
            ],
            color: ['#409EFF', '#67C23A', '#E6A23C', '#F56C6C', '#909399'],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      this.pieChartInstance.setOption(option);
      window.addEventListener('resize', this.handleResize);
    },
    handleResize() {
      if (this.lineChartInstance) this.lineChartInstance.resize();
      if (this.pieChartInstance) this.pieChartInstance.resize();
    }
  },
  beforeDestroy() {
    window.removeEventListener('resize', this.handleResize);
    if (this.lineChartInstance) {
      this.lineChartInstance.dispose();
      this.lineChartInstance = null;
    }
    if (this.pieChartInstance) {
      this.pieChartInstance.dispose();
      this.pieChartInstance = null;
    }
  }
};
</script>

<style scoped>
.dashboard-container {
  padding: 20px;
  background-color: #f0f2f5;
  min-height: calc(100vh - 120px);
}

.top-cards {
  margin-bottom: 20px;
}

.metric-card {
  border-radius: 8px;
  border: none;
  overflow: hidden;
  transition: all 0.3s ease;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
}

.metric-card:hover {
  transform: translateY(-4px);
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.15);
}

.metric-card /deep/ .el-card__body {
  padding: 0;
}

.card-content {
  padding: 20px;
  display: flex;
  align-items: center;
  gap: 16px;
}

.card-icon {
  width: 56px;
  height: 56px;
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 26px;
  background: rgba(255, 255, 255, 0.25);
  color: #fff;
}

.card-info {
  flex: 1;
}

.card-title {
  font-size: 14px;
  color: rgba(255, 255, 255, 0.9);
  margin-bottom: 6px;
}

.card-value {
  font-size: 26px;
  font-weight: bold;
  color: #fff;
}

/* 各卡片渐变色 - 低饱和度清新渐变 */
.users-card {
  background: linear-gradient(135deg, #5EC9A8 0%, #3DB89A 100%);
}
.products-card {
  background: linear-gradient(135deg, #7DC9E8 0%, #5BB8DB 100%);
}
.orders-card {
  background: linear-gradient(135deg, #A5D4F0 0%, #85C5E8 100%);
}
.transaction-card {
  background: linear-gradient(135deg, #7ECBA1 0%, #5EBB87 100%);
}

.chart-card {
  border-radius: 8px;
  border: none;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.08);
  background: #fff;
}

.chart-card /deep/ .el-card__header {
  font-size: 15px;
  font-weight: bold;
  color: #303133;
  border-bottom: 1px solid #f0f0f0;
  padding: 14px 20px;
  background: linear-gradient(135deg, #fafafa 0%, #f5f5f5 100%);
}

.chart-card /deep/ .el-card__body {
  padding: 20px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

.middle-charts .el-col {
  margin-bottom: 20px;
}
</style>